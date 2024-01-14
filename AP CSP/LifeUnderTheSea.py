
from cmu_graphics import *

# Labels and initial setup
Question = Label('100,000 sea mammals die every year due to pollution.', 200, 29, size=13)
counter = Label('yet', 200, 48, size=16, fill='green')
Question.visible = False
counter.visible = False

# Fish groups
fish1 = Group(
    Oval(80, 180, 40, 30, fill=gradient('gold', 'yellow', start='left')),
    Polygon(80 - 20, 180, 80 - 30, 180 - 20, 80 - 30, 180 + 20, fill=gradient('gold', 'yellow', start='left')),
    Circle(80 + 9, 180 - 5, 2)
)
fish2 = Group(
    Oval(160, 205, 40, 30, fill=gradient('gold', 'yellow', start='left')),
    Polygon(160 - 20, 205, 160 - 30, 205 - 20, 160 - 30, 205 + 20, fill=gradient('gold', 'yellow', start='left')),
    Circle(160 + 9, 205 - 5, 2)
)
fish3 = Group(
    Oval(50, 290, 40, 30, fill=gradient('gold', 'yellow', start='left')),
    Polygon(50 - 20, 290, 50 - 30, 290 - 20, 50 - 30, 290 + 20, fill=gradient('gold', 'yellow', start='left')),
    Circle(50 + 9, 290 - 5, 2)
)
fish4 = Group(
    Oval(160, 290, 40, 30, fill=gradient('gold', 'yellow', start='left')),
    Polygon(160 - 20, 290, 160 - 30, 290 - 20, 160 - 30, 290 + 20, fill=gradient('gold', 'yellow', start='left')),
    Circle(160 + 9, 290 - 5, 2)
)
fish5 = Group(
    Oval(200, 140, 40, 30, fill=gradient('gold', 'yellow', start='left')),
    Polygon(200 - 20, 140, 200 - 30, 140 - 20, 200 - 30, 140 + 20, fill=gradient('gold', 'yellow', start='left')),
    Circle(200 + 9, 140 - 5, 2)
)
fish6 = Group(
    Oval(70, 70, 40, 30, fill=gradient('gold', 'yellow', start='left')),
    Polygon(70 - 20, 70, 70 - 30, 70 - 20, 70 - 30, 70 + 20, fill=gradient('gold', 'yellow', start='left')),
    Circle(70 + 9, 70 - 5, 2)
)
fishes = Group(fish1, fish2, fish3, fish4, fish5, fish6)
fishes.visible = False

# Set background
app.background = gradient('white', 'cyan', 'midnightBlue', start='top')

# Introduction labels
Intro = Label('Life UnderWater!', 200, 100, size=28, bold=True, font='arial')
Intro1 = Label('The goal of sustainable development goal #14 is to ', 200, 150, size=16)
Intro2 = Label(' keep the Ocean clean. ', 200, 170, size=16)
Intro3 = Label('We want to limit pollution in order ', 200, 190, size=16)
Intro4 = Label('to sustain sealife. ', 200, 220, size=16)
Intro5 = Label(' In this game you must answer a series  ', 200, 240, size=16)
Intro6 = Label(' of true or false questions. If ', 200, 260, size=16)
Intro7 = Label('you answer wrong then a fish dies.', 200, 280, size=16)
Start = Label('Press (Enter) to Start', 200, 320, size=35, bold=True)

# Event handler for key press
def onKeyPress(key):
    if key == 'enter':
        Intro.visible = False
        Intro1.visible = False
        Intro2.visible = False
        Intro3.visible = False
        Intro4.visible = False
        Intro5.visible = False
        Intro6.visible = False
        Intro7.visible = False
        Start.visible = False
        fishes.visible = True
        Question.visible = True
        counter.visible = False
        
    # Questions 
    if Question.value == '100,000 sea mammals die every year due to pollution.':
        app.message = app.getTextInput()
        if app.message.lower() == "true":
            counter.fill = 'green'
            counter.value = 'Good Work, you got the answer correct!'
            counter.visible = True
            Question.value = 'We have dumped less than 1 billion pounds of garbage in the ocean.'
        elif app.message.lower() == "false":
            counter.value = 'Try again next time!'
            counter.fill = 'red'
            fishes.remove(fish1)
            Question.value = 'We have dumped less than 1 billion pounds of garbage in the ocean.'
    
    elif Question.value == 'We have dumped less than 1 billion pounds of garbage in the ocean.':
        app.message = app.getTextInput('Enter a message')
        if app.message.lower() == "true":
            counter.value = 'Try again next time!'
            counter.fill = 'red'
        elif app.message.lower() == "false":
            counter.fill = 'green'
            counter.value = 'Good Work, you got the answer correct!'
            
            # Hide all labels and fishes after answering the second question
            Intro.visible = False
            Intro1.visible = False
            Intro2.visible = False
            Intro3.visible = False
            Intro4.visible = False
            Intro5.visible = False
            Intro6.visible = False
            Intro7.visible = False
            Start.visible = False
            fishes.visible = False
            Question.visible = False
            counter.value = 'Game Over'

# Event handler for fish animation
def onStep():
    fishes.centerX += 5
    if fishes.left > 400:
        fishes.right = 0

cmu_graphics.run()
