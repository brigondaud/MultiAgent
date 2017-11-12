# Ensimag 2A POO - TP 2015/16
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: TestAutomataConway TestAutomataImmigration TestAutomataSchelling TestBalls TestBallsSimulator TestBoidHunting TestBoidSystem TestBoidWinds TestDrawGraphicalBoid TestEventManager TestGUI

TestAutomataConway:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestAutomataConway.java

TestAutomataImmigration:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestAutomataImmigration.java

TestAutomataSchelling:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestAutomataSchelling.java

TestBalls:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestBalls.java

TestBallsSimulator:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestBallsSimulator.java

TestBoidHunting:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestBoidHunting.java

TestBoidSystem:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestBoidSystem.java

TestBoidWinds:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestBoidWinds.java

TestDrawGraphicalBoid:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestDrawGraphicalBoid.java

TestEventManager:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestEventManager.java

TestGUI:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestGUI.java

# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM

exeTestAutomataConway:
	java -classpath bin:lib/gui.jar test/TestAutomataConway

exeTestAutomataImmigration:
	java -classpath bin:lib/gui.jar test/TestAutomataImmigration

exeTestAutomataSchelling:
	java -classpath bin:lib/gui.jar test/TestAutomataSchelling

exeTestBalls:
	java -classpath bin:lib/gui.jar test/TestBalls

exeTestBallsSimulator:
	java -classpath bin:lib/gui.jar test/TestBallsSimulator

exeTestBoidHunting:
	java -classpath bin:lib/gui.jar test/TestBoidHunting

exeTestBoidSystem:
	java -classpath bin:lib/gui.jar test/TestBoidSystem

exeTestBoidWinds:
	java -classpath bin:lib/gui.jar test/TestBoidWinds

exeTestDrawGraphicalBoid:
	java -classpath bin:lib/gui.jar test/TestDrawGraphicalBoid

exeTestEventManager:
	java -classpath bin:lib/gui.jar test/TestEventManager

exeTestGUI:
	java -classpath bin:lib/gui.jar test/TestGUI

#Clean
clean:
	rm -rf bin/*

