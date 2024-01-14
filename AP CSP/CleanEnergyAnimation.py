# This program creates a Clean energy Animation showing an example of using wind power as a renewable energy source.
# This program creates an animated visualization of clean energy concepts using the cmu_graphics library. 
# It starts with an introduction, and upon pressing 'Enter', reveals an interactive animation featuring elements 
# like a windmill, electrons, and a transformer. This animation emphasizes the importance of investing in clean
# energy infrastructure and technology for environmental sustainability and growth.
from cmu_graphics import *

# Set background gradient
app.background = gradient('red', 'orange', 'gold', 'yellow', start='top')

# Create sky and grass for the background
sky = Rect(0, 0, 400, 225, fill=gradient('deepSkyBlue', 'lightCyan', 'yellow', start='top'))
grass = Rect(0, 225, 400, 175, fill=gradient('forestGreen', 'mediumSeaGreen', 'lightGreen', start='top'))

# Create star shape for the fan
fan = Star(90, 130, 60, 4, fill='grey')

# Labels for the introduction
Intro = Label('Clean Energy!', 200, 100, size=28, bold=True, font='arial')
Intro1 = Label('The goal of sustainable development goal #7 is to', 200, 150, size=16)
Intro2 = Label('invest in solar, wind, and thermal power,', 200, 170, size=16)
Intro3 = Label('improve energy productivity, and insure energy', 200, 190, size=16)
Intro4 = Label('for all is vital. Expand infrastructure and', 200, 220, size=16)
Intro5 = Label('upgrade technology to provide clean and more efficient', 200, 240, size=16)
Intro6 = Label('energy in all countries to encourage growth and. help the', 200, 260, size=16)
Intro7 = Label('environment. Click the screen to start the animation.', 200, 280, size=16)

# Group with window elements
window = Group(
    Rect(390, 150, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(390, 180, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(390, 210, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(267, 150, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(288, 150, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(288, 180, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(267, 180, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(267, 210, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(288, 210, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(325, 120, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(355, 120, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(325, 150, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(355, 150, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(325, 180, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(355, 180, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(325, 210, 12, 17, border='white', borderWidth=2.5, align='center'),
    Rect(355, 210, 12, 17, border='white', borderWidth=2.5, align='center')
)

# Labels and circles for electrons and animation
intro = Label('Press (Enter) To Continue', 200, 330, size=20, bold=True)
Electron = Circle(90, 290, 5, fill='orange')
Electron1 = Circle(291, 250, 5, fill='yellow')
Electron2 = Circle(305, 250, 5, fill='yellow')
Electron3 = Circle(319, 252, 5, fill='yellow')
Electron1.dy = -0.25
Electron1.dx = -0.13
Electron2.dy = -0.25
Electron2.dx = 0.35
Electron3.dy = -0.27
Electron3.dx = 0.76
c = Label(0, 200, 200, size=80)

# Cloud elements in background
cloud = Group(
    Circle(340, 35, 23, fill='white', border='gainsboro', borderWidth=3),
    Circle(300, 55, 28, fill='white', border='gainsboro', borderWidth=3),
    Circle(373, 55, 28, fill='white', border='gainsboro', borderWidth=3),
    Circle(330, 65, 26, fill='white', border='gainsboro')
)

# Set initial visibility for elements
window.visible = False
c.visible = False
fan.visible = False
grass.visible = False
sky.visible = False
cloud.visible = False
Electron.visible = False
Electron1.visible = False
Electron2.visible = False
Electron3.visible = False

# Handle key press event
def onKeyPress(key):
    if key == 'enter':
        # Hide introduction labels
        Intro.visible = False
        Intro1.visible = False
        Intro2.visible = False
        Intro3.visible = False
        Intro4.visible = False
        Intro5.visible = False
        Intro6.visible = False
        Intro7.visible = False
        c.visible = False
        Electron.visible = False
        Electron1.visible = False
        Electron2.visible = False
        Electron3.visible = False
        intro.visible = False
        # Show animation elements
        Polygon(180, 225, 370, 90, 400, 123, 405, 225, fill=gradient('gold', 'goldenrod', start='top'))
        Polygon(-20, 120, 18, 105, 253, 225, 0, 225, fill=gradient('orange', 'tomato', start='top'))
        sky.visible = True
        grass.visible = True
        fan.visible = True
        cloud.visible = True
        Line(90, 290, 90, 150, lineWidth=6, fill='lightGrey')
        base = Circle(90, 130, 10, fill='black')
        fan.toFront()
        base.toFront()
        Rect(310, 95, 60, 130, fill='slateGray')
        Rect(253, 125, 50, 100, fill='slateGray')
        Rect(380, 125, 50, 100, fill='slateGray')
        window.visible = True
        window.toFront()
        Line(90, 290, 275, 290, arrowEnd=True)
        Rect(265, 260, 63, 63, fill='silver')
        Line(295, 260, 278, 225)
        Line(295, 260, 340, 225)
        Line(295, 260, 395, 225)
        Label('Transformer', 296, 290, size=11, bold=True)
        Electron.toFront()

# Handle animation step
def onStep():
    fan.rotateAngle += 2
    cloud.centerX += 1
    if Electron.centerX >= 295:
        Electron.visible = False
        Electron1.visible = True
        Electron2.visible = True
        Electron3.visible = True
        Electron1.centerX += Electron1.dx
        Electron1.centerY += Electron1.dy
        Electron2.centerX += Electron2.dx
        Electron2.centerY += Electron2.dy
        Electron3.centerX += Electron3.dx
        Electron3.centerY += Electron3.dy
        if Electron1.centerX <= 278:
            Electron.visible = False
            Electron1.visible = False
            Electron2.visible = False
            Electron3.visible = False
            window.fill = 'yellow'
    if c.value == True:
        Electron.centerX += 2
    if cloud.left > 400:
        cloud.right = 0

# Set Electron to the front
Electron.toFront()
counter = Label(0, 200, 200, size=80)

counter.visible = False

# Handle mouse press event
def onMousePress(mouseX, mouseY):
    counter.value += 1
    if counter.value % 2 == 1:
        Electron.centerX = 90
        Electron.visible = True
        c.value = True
        Electron.centerX = 90
        Electron.centerY = 290
        Electron2.centerX = 305
        Electron2.centerY = 250
        Electron1.centerX = 291
        Electron1.centerY = 250
        Electron3.centerX = 319
        Electron3.centerY = 252
        window.fill = 'black'
        if Electron.centerX >= 295:
            Electron.visible = False
            Electron1.visible = True
            Electron2.visible = True
            Electron3.visible = True
            if Electron1.centerX <= 278:
                Electron.centerX = 90
                Electron.centerY = 290
                Electron1.centerX = 305
                Electron1.centerY = 250
                Electron2.centerX = 291
                Electron2.centerY = 250
                Electron3.centerX = 319
                Electron3.centerY = 252
                window.fill = 'yellow'
    elif counter.value % 2 == 0:
        Electron.visible = False
        Electron1.visible = False
        Electron2.visible = False
        Electron3.visible = False
        window.fill = 'black'


cmu_graphics.run()
