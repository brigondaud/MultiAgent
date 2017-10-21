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

all: testGUI TestBallsSimulator TestAutomata TestImmigrationGame

testGUI:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestGUI.java

TestBallsSimulator:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestBallsSimulator.java

TestAutomata:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestAutomata.java

TestImmigrationGame:
	javac -d bin -classpath lib/gui.jar -sourcepath src src/test/TestImmigrationGame.java

# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM
exeGUI:
	java -classpath bin:lib/gui.jar test/TestGUI

exeBallsSimulator:
	java -classpath bin:lib/gui.jar test/TestBallsSimulator

exeTestAutomata:
	java -classpath bin:lib/gui.jar test/TestAutomata

exeImmigrationGame:
	java -classpath bin:lib/gui.jar test/TestImmigrationGame

clean:
	rm -rf bin/*.class

