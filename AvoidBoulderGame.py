from cmu_graphics import *

# Stick figure
stickPerson = Group(
    Circle(200, 285, 9, fill='black'),  # Head
    Line(200, 285, 200, 320, fill='black', lineWidth=2),  # Body
    Line(200, 320, 190, 340, fill='black', lineWidth=2),  # Left leg
    Line(200, 305, 180, 290, fill='black', lineWidth=2),  # Left arm
    Line(200, 305, 220, 290, fill='black', lineWidth=2),  # Right arm
    Line(200, 320, 210, 340, fill='black', lineWidth=2)   # Right leg
)

# Setup
counter = Label(0, -20, 0)  # Counter for game state
counter.value = 0
ground = Rect(0, 340, 400, 60, fill=gradient('dimGrey', 'gray', 'silver', start='bottom'))  # Ground rectangle
ground.visible = False
stickPerson.visible = False
rock = Group()  # Group for the first type of rock
rock2 = Group()  # Group for the second type of rock
rock.visible = False
rock2.visible = False
app.background = ('black')  # Initial background color
Intro = Label('Avoid the Boulders!', 200, 100, fill='white', size=28, bold=True, font='aria')  # Game title
Intro1 = Label('The goal of this game is to avoid the rocks ', 200, 150, fill='white', size=18)  # Game instructions
Intro2 = Label('falling from the sky. Once you avoid 40 rocks you', 200, 170, fill='white', size=18)  # Game instructions
Intro3 = Label('win. If you get hit by a rock 3 times you lose.', 200, 190, fill='white', size=18)  # Game instructions
Rule1 = Label('Press (Enter) to start', 200, 310, fill='white', size=24)  # Rule to start the game
Rule2 = Label('Press (R) to restart', 200, 340, fill='white', size=24)  # Rule to restart the game
Label('Lives:', 340, 10, size=20)  # Label for displaying remaining lives
Lives = Label(3, 380, 10, size=20)  # Initial lives count
Score = Label(0, 70, 10, size=20)  # Initial score count
Label('Score:', 30, 10, size=20)  # Label for displaying the score
timer = Label(0, 360, 385, fill='white', size=18)  # Timer label
timer.toFront()
rock.centerY = 0
rock2.centerY = 0

# Used to restart game!
def restart():
    counter.value = 0
    Intro.value = 'Avoid the Boulders!'
    Score.value = 0
    timer.value = 0
    Lives.value = 3
    rock.clear()
    rock2.clear()
    app.background = ('black')
    Intro.visible = True
    Intro1.visible = True
    Intro2.visible = True
    Intro3.visible = True
    ground.visible = False
    stickPerson.visible = False
    Rule1.visible = True
    Rule2.visible = True

def onKeyPress(key):
    # Start game when you press enter.
    if key == 'enter':
        counter.value = 1
        Score.value = 0
        Lives.value = 3
        timer.value = 0
        app.background = gradient('deepSkyBlue', 'skyBlue', 'lightblue', start='top')
        ground.visible = True
        stickPerson.visible = True
        stickPerson.toFront()
        Intro.visible = False
        Intro1.visible = False
        Intro2.visible = False
        Intro3.visible = False
        Rule1.visible = False
        Rule2.visible = False
        rock.visible = True
        rock2.visible = True
        rock.toFront()
        timer.toFront()
    # Calling restart function to restart when r is pressed
    if key == 'r':
        restart()

# Keys to move the stick figure right and left.
def onKeyHold(keys):
    if 'right' in keys:
        stickPerson.centerX += 7
    if 'left' in keys:
        stickPerson.centerX -= 7
        stickPerson.toFront()
    if stickPerson.right > 400:
        stickPerson.right = 400
    if stickPerson.left < 0:
        stickPerson.left = 0
        stickPerson.toFront()

def addRock(rock):
    rock.toFront()
    rock.add(Star(randrange(20, 380), 0, 45, 3, fill=gradient('darkGray', 'gray')))

def addRock2(rock2):
    rock2.toFront()
    rock2.add(Circle(randrange(20, 380), 0, 33, fill='gray'))

def getincrement(x):
    stickPerson.toBack()
    return x / 100 + 13

def onStep():
    if counter.value == 0:
        rock.clear()
        rock2.clear()
        timer.value = 0
        timer.value += 0
        rock.visible = False
        rock2.visible = False
    # Calling another function made by me to increase boulder speed progressively.
    if counter.value == 1:
        rock2.centerY += getincrement(timer.value)
        rock.centerY = rock.centerY + getincrement(timer.value)
        timer.value += 1
    # Boulder 1 and 2 dropping from the sky at random places using two different
    # functions made by me.
    if timer.value % 30 == 1:
        addRock(rock)
        stickPerson.toFront()
    if timer.value % 40 == 0:
        addRock2(rock2)
        rock2.centerY += 1 + getincrement(timer.value)
        stickPerson.toFront()
    if rock.bottom >= 340:
        rock.clear()
        Score.value += 1
    if rock2.bottom >= 340:
        rock2.clear()
        Score.value += 1
    if rock.hitsShape(stickPerson) == True:
        stickPerson.toFront()
        rock.clear()
        Lives.value -= 1
    if rock2.hitsShape(stickPerson) == True:
        stickPerson.toFront()
        rock2.clear()
        Lives.value -= 1
    if Lives.value < 1:
        app.background = 'black'
        ground.visible = False
        stickPerson.visible = False
        stickPerson.toFront()
        Intro.visible = True
        Intro.value = "YOU LOSE!"
        Intro1.visible = False
        Intro2.visible = False
        Intro3.visible = False
        Rule1.visible = False
        Rule2.visible = False
        rock.visible = False
        rock2.visible = False
        timer.value = 0
        timer.value += 0
        rock.centerY = 0
        rock2.centerY = 0
    if Score.value == 40:
        app.background = 'black'
        ground.visible = False
        stickPerson.visible = False
        stickPerson.toFront()
        Intro.visible = True
        Intro.value = "YOU WIN!"
        Intro1.visible = False
        Intro2.visible = False
        Intro3.visible = False
        Rule1.visible = False
        Rule2.visible = False
        rock.visible = False
        rock2.visible = False
        timer.value = 0
        timer.value += 0
        rock.centerY = 0
        rock2.centerY = 0

cmu_graphics.run()
