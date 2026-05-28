# sae_02_ExploAlgo_PASHOkevin_HELOUANEkayis
Kevin PASHO groupe S2D
Kayis HELOUANE groupe S2D

Ce projet implémente deux algorithmes de recherche de plus court chemin dans
un graphe oriente pondere, puis les applique au
reseau de bus STAN de l'agglomeration nanceenne

    sae_02_ExploAlgo_PASHOkevin_HELOUANEkayis/
    |-- README.md
    |-- src/                       
    |   |-- Arc.java             
    |   |-- Arcs.java              
    |   |-- Graphe.java            
    |   |-- GrapheListe.java      
    |   |-- Valeurs.java           
    |   |-- Principale.java        
    |   |-- BellmanFord.java       
    |   |-- MainBellmanFord.java  
    |   |-- Dijkstra.java          
    |   |-- MainDijkstra.java    
    |   |-- LireReseau.java        
    |   |-- MainTransport.java    
    |   |-- stan.nodes.txt         
    |   |-- stan.edges.txt        
    |   |-- GrapheListeTest.java
    |   |-- BellmanFordTest.java
    |   |-- DijkstraTest.java
    |   |-- LireReseauTest.java
    |-- SAE-2.02-GUI/            

Generer le fichier jar
Depuis la racine du projet

    cd src

    javac -d out Arc.java Arcs.java Graphe.java GrapheListe.java Valeurs.java Principale.java BellmanFord.java MainBellmanFord.java Dijkstra.java MainDijkstra.java LireReseau.java MainTransport.java

    jar --create --file MainTransport.jar --main-class MainTransport -C out .

lancer l'interface graphique
Depuis la racine du projet

    cd SAE-2.02-GUI
    python -m venv venv
    venv\Scripts\activate
    pip install -r requirements.txt
    python main-gui.py --jar ..\src\MainTransport.jar
