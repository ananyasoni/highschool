# This program is a game where the user tries catching falling seeds to score points. 
# The theme highlights sustainable development goal #15, emphasizing forest management. 
# The player wins with a score of 21, resulting in a victory screen, and loses if the 
# score turns  negative. 

from cmu_graphics import *

# Sheep
sheep = Group(
    Line(105, 355, 105, 380, lineWidth=4),
    Line(150, 355, 150, 380, lineWidth=4),
    Circle(105, 320, 20, fill='white', border='gainsboro'),
    Oval(75, 340, 45, 35, rotateAngle=-30),
    Circle(70, 335, 3, fill='ghostWhite'),
    Circle(69, 336, 1),
    Circle(100, 340, 20, fill='white', border='gainsboro'),
    Circle(125, 350, 20, fill='white', border='gainsboro'),
    Circle(160, 345, 20, fill='white', border='gainsboro'),
    Circle(130, 310, 20, fill='white', border='gainsboro'),
    Circle(155, 315, 20, fill='white', border='gainsboro'),
    Circle(130, 330, 30, fill='white')
)

# Trees
Tree1 = Group(
    Circle(40, 280, 30, fill='forestGreen'),
    Circle(40, 250, 23, fill='forestGreen'),
    Circle(40, 225, 10, fill='forestGreen'),
    Line(40, 240, 40, 340, fill='saddleBrown', lineWidth=5)
)
Tree2 = Group(
    Circle(100, 280, 30, fill='forestGreen'),
    Circle(100, 250, 23, fill='forestGreen'),
    Circle(100, 225, 10, fill='forestGreen'),
    Line(100, 240, 100, 340, fill='saddleBrown', lineWidth=5)
)
Tree3 = Group(
    Circle(160, 280, 30, fill='forestGreen'),
    Circle(160, 250, 23, fill='forestGreen'),
    Circle(160, 225, 10, fill='forestGreen'),
    Line(160, 240, 160, 340, fill='saddleBrown', lineWidth=5)
)
Tree4 = Group(
    Circle(220, 280, 30, fill='forestGreen'),
    Circle(220, 250, 23, fill='forestGreen'),
    Circle(220, 225, 10, fill='forestGreen'),
    Line(220, 240, 220, 340, fill='saddleBrown', lineWidth=5)
)
Tree5 = Group(
    Circle(280, 280, 30, fill='forestGreen'),
    Circle(280, 250, 23, fill='forestGreen'),
    Circle(280, 225, 10, fill='forestGreen'),
    Line(280, 240, 280, 340, fill='saddleBrown', lineWidth=5)
)
Tree6 = Group(
    Circle(340, 280, 30, fill='forestGreen'),
    Circle(340, 250, 23, fill='forestGreen'),
    Circle(340, 225, 10, fill='forestGreen'),
    Line(340, 240, 340, 340, fill='saddleBrown', lineWidth=5)
)

# Stick figure
stickPerson = Group(
    Circle(200, 285, 9, fill='black'),
    Line(200, 285, 200, 320, fill='black', lineWidth=2),
    Line(200, 320, 190, 340, fill='black', lineWidth=2),
    Line(200, 305, 180, 290, fill='black', lineWidth=2),
    Line(200, 305, 220, 290, fill='black', lineWidth=2),
    Line(200, 320, 210, 340, fill='black', lineWidth=2)
)

# Setup
Lose = Label('GAME OVER!', 200, 200, size=50)
Lose.visible = False
ground = Rect(0, 340, 400, 60, fill=gradient('yellowGreen', 'forestGreen', start='top'))
ground2 = Rect(0, 380, 400, 20, fill=gradient('yellowGreen', 'forestGreen', start='top'))
Tree1.visible = False
Tree2.visible = False
Tree3.visible = False
Tree4.visible = False
Tree5.visible = False
Tree6.visible = False
ground.visible = False
ground2.visible = False
stickPerson.visible = False
sheep.visible = False

app.background = ('black')
Intro = Label('Life On Land!', 200, 100, fill='white', size=28, bold=True, font='arial')
Intro1 = Label('The goal of sustainable development goal #15 is to ', 200, 150, fill='white', size=16)
Intro2 = Label(' promote sustainable use of ecosystems while managing ', 200, 170, fill='white', size=16)
Intro3 = Label('  forests. This could mean limiting deforestation.', 200, 190, fill='white', size=16)
Intro4 = Label('The goal of this game is to catch at least 21 seeds. ', 200, 220, fill='white', size=17)
Intro5 = Label(' If your score turns negative you lose. This shows   ', 200, 240, fill='white', size=17)
Intro6 = Label(' how deforestation negatively affects the environment. ', 200, 260, fill='white', size=17)
Intro7 = Label('We should plant trees instead of killing them.', 200, 280, fill='white', size=17)
Rule1 = Label('Press(Enter) to start', 200, 310, fill='white', size=24)
Rule2 = Label('Press(R) to restart', 200, 340, fill='white', size=24)

def onKeyPress(key):
    # Start game when you press enter.
    if key == 'enter':
        Lose.visible = False
        app.background = gradient('lightSkyBlue', 'skyBlue', 'lightblue')
        ground.visible = True
        random.value = 0
        constraint.value = 100
        stickPerson.visible = True
        stickPerson.toFront()
        score.value = 0
        ground2.visible = False
        Intro.visible = False
        Intro1.visible = False
        Intro2.visible = False
        Intro3.visible = False
        Intro4.visible = False
        Intro5.visible = False
        Intro6.visible = False
        Intro7.visible = False
        Rule1.visible = False
        Rule2.visible = False
        seed.toFront()
    # To restart fresh game press r.
    if key == 'r':
        seed.visible = True
        ground2.visible = False
        sheep.visible = False
        random.value = 0
        constraint.value = 100
        app.background = ('black')
        Intro.visible = True
        Intro7.visible = True
        Intro4.visible = True
        Intro5.visible = True
        Intro6.visible = True
        ground.visible = False
        Rule1.visible = True
        Rule2.visible = True
        stickPerson.visible = False
        score.value = 0

# Setup score and random value for seed to drop.
score = Label(0, 380, 10, size=20)
random = Label(0, 200, 200)
random.visible = False
constraint = Label(100, 300, 200)
Label('Score:', 340, 10, size=20)
constraint.visible = False

# Keys to move the stick figure right and left plus wrap around the screen.
def onKeyHold(keys):
    ground2.visible = False
    if 'right' in keys:
        stickPerson.centerX += 4
    if 'left' in keys:
        stickPerson.centerX -= 4
        stickPerson.toFront()
    if stickPerson.centerX > 400:
        stickPerson.centerX = 0
    if stickPerson.centerX < 0:
        stickPerson.centerX = 400
        stickPerson.toFront()

seed = Group()
# Sheep wraps around the screen on victory slide.
def onStep():
    sheep.centerX -= 3
    if sheep.right <= 0:
        sheep.left = 400
    random.value += 1
    # Seed drops from sky at a random x-position
    if random.value >= constraint.value:
        seed.add(
            Circle(randrange(0, 400), 0, 4, fill='orange')
        )
        random.value = 0
        constraint.value = constraint.value - 1
    if constraint.value == 75:
        constraint.value = 100

    seed.centerY += 5
    if seed.centerY == 340:
        seed.clear()
        score.value -= 1
    if seed.hitsShape(stickPerson):
        score.value += 1
        stickPerson.toFront()
        seed.clear()
    # Score conditionals.
    if score.value < 0:
        Tree1.visible = False
        Tree2.visible = False
        Tree3.visible = False
        Tree4.visible = False
        Tree5.visible = False
        Tree6.visible = False
        Lose.value = ("GAME OVER!")
        Lose.visible = True
        random.value = 0
        constraint.value = 0
        seed.clear()
    # Tree 1 appears when you have a score of 3.
    if score.value <= 3:
        Tree1.visible = False
        Tree2.visible = False
        Tree3.visible = False
        Tree4.visible = False
        Tree5.visible = False
        Tree6.visible = False
    # Tree 1 appears when you have a score of 3.
    if score.value >= 3:
        Tree2.visible = False
        Tree1.visible = True
        Tree3.visible = False
        Tree4.visible = False
        Tree5.visible = False
        Tree6.visible = False
    # Tree 2 appears when you have a score of 6.
    if score.value >= 6:
        Tree1.visible = True
        Tree2.visible = True
        Tree3.visible = False
        Tree4.visible = False
        Tree5.visible = False
        Tree6.visible = False
    # Tree 3 appears when you have a score of 9.
    if score.value >= 9:
        Tree1.visible = True
        Tree2.visible = True
        Tree3.visible = True
        Tree4.visible = False
        Tree5.visible = False
        Tree6.visible = False
    # Tree 4 appears when you have a score of 12.
    if score.value >= 12:
        Tree1.visible = True
        Tree2.visible = True
        Tree3.visible = True
        Tree4.visible = True
        Tree5.visible = False
        Tree6.visible = False
    # Tree 5 appears when you have a score of 15.
    if score.value >= 15:
        Tree1.visible = True
        Tree2.visible = True
        Tree3.visible = True
        Tree4.visible = True
        Tree5.visible = True
        Tree6.visible = False
    # Tree 6 appears when you have a score of 20.
    if score.value >= 20:
        Tree1.visible = True
        Tree2.visible = True
        Tree3.visible = True
        Tree4.visible = True
        Tree5.visible = True
        Tree6.visible = True
    # When you have a total of 21 points it goes to victory screen!
    if score.value >= 21:
        seed.clear()
        Lose.value = ('YOU WIN!')
        Lose.visible = True
        seed.visible = False
        sheep.visible = True
        Tree1.visible = False
        Tree2.visible = False
        Tree3.visible = False
        Tree4.visible = False
        Tree5.visible = False
        Tree6.visible = False
        ground.visible = False
        ground2.visible = True
        stickPerson.visible = False

cmu_graphics.run()
