# Anwendung FinanzApp
Diese Anwendung ist im Rahmen einer Klausurersatzleistung des Faches Programmieren entstanden.
Zweck dieses Programmes ist es, einen geordneten Überblick über die eigenen Finanzen zu behalten.
Für die Umsetzung werden die Benutzerdaten im gehashten Zustand und die Finanzdaten auf einer MySQL Datenbank gespeichert.
Um die Anwendung verwenden zu können, muss eine MySQL Datenbank installiert sein oder die URL und das Password in der entsprechenden Klasse geändert werden.
Nach dem Start der Anwendung öffnet sich eine Login/Registrierungsmaske, für die Verifizierung einer Zugriffserlaubnis.
****
## Inhaltsverzeichnis
1. Projektbeschreibung
2. Inhaltsverzeichnis
3. Installationsanleitung
4. Technologies
****
## Leitfaden für die Installation unter Windows:
### Schritt 1:
Zunächst wird der MySQL Server auf der offiziellen Herstellerseite heruntergeladen.

[https://dev.mysql.com/downloads/installer/]()

Auf der Installationsseite wird das Betriebssystem "Windows" angewählt und die Datei heruntergeladen.
### Schritt 2:

Anschließend wird der Installer ausgeführt und den Anweisungen des Installers Folge geleistet.

Folgende Informationen sind notwendig für die Installation:

Verwendeter Port : 3306

Es ist erforderlich die Informationen in der Klasse 
org.example.FinanzÜbersicht.Backend.Database.DatabaseConnector zu ersetzen.
### Schritt 3:

Nachdem die Installation erfolgreich abgeschlossen wurde, muss eine neue Datenbank namens "finances" angelegt werden.

Hierzu wird mit einer Shell im Installationsverzeichnis die Datei mysql.exe ausgeführt.

Das Standardverzeichnis ist: C:\Program Files\MySQL\MySQL-Server\bin\

Command : `mysql.exe -u root -p`

Bei erfolgreichem Login wird folgende Query ausgeführt:
`CREATE DATABASE finances;`

`USE finances;`

Nun wird die Datenbank finances konfiguriert. Folgende Befehle sind auszuführen:
`CREATE TABLE Finanzen(id int(3) AUTO_INCREMENT, date DATE, value int(3), PRIMARY KEY (id))`
`CREATE TABLE User(id int(3) AUTO_INCREMENT, benutzer_name varchar(255), email varchar(255), password varchar(255), PRIMARY KEY (id))`

Um die Verifizierungsmail verwenden zu können, müssen die Zugangsdaten für einen E-Mail-Account in der Klasse MailService angepasst werden.

Bei Erfolg sind die Vorbereitungen abgeschlossen und die Anwendung kann gestartet werden.

## Leitfaden für die Installation unter Linux:

### Schritt 1:

Zunächst werden die Paketquellen aktualisiert und der MySQL Server aus den Paketquellen geladen.

`sudo apt update && sudo apt upgrade`

`sudo apt install mysql-server -y`

Nach erfolgreicher Installation müssen in der Klasse DatabaseConnector das Passwort und der
Benutzername ersetzt werden.

### Schritt 2:

Nachdem die Installation erfolgreich abgeschlossen wurde, muss eine neue Datenbank namens "noten" angelegt werden.

Hierzu wird in einem Terminal folgender Befehl eingegeben:

`sudo mysql -u root -p`

Bei erfolgreichem Login wird folgende Query ausgeführt:

`CREATE DATABASE finances;`

`USE finances;`

Nun wird die Datenbank finances konfiguriert. Folgende Befehle sind auszuführen:
`CREATE TABLE Finanzen(id int(3) AUTO_INCREMENT, date DATE, value int(3), PRIMARY KEY (id))`

`CREATE TABLE User(id int(3) AUTO_INCREMENT, benutzer_name varchar(255), email varchar(255), password varchar(255), PRIMARY KEY (id))`

Bei Erfolg sind die Vorbereitungen abgeschlossen und die Anwendung kann gestartet werden.

****
## Alternativen
Für den Fall, dass die Datenbank nicht lokal laufen soll, ist die IPv4 Adresse und der konfigurierte Port in der Klasse DatabaseConnector einzutragen.
****
## Bekannte Fehler und dessen Behebung:

Wenn der MySQL Server bei Systemstart nicht gestartet wird und eine Verbindung demnach nicht möglich ist, kann dieser manuell gestartet werden.
Hierbei wird die Anwendung `Services` über die Ausführen-Funktion gestartet.

In dem Fenster wird der Prozess `MySQL80` gesucht und angeklickt.

Oben links im Fenster erscheint eine blau hinterlegte Schrift `Den Dienst starten`.

Nach dem Start kann die Anwendung wieder geschlossen werden und eine Verbindung zur Datenbank ist nun möglich.

Sollten Fehler mit dem Senden der Verifizierungsmail unter Verwendung von gmail auftreten hilft folgender Artikel weiter:

[https://support.google.com/accounts/answer/185833](https://support.google.com/accounts/answer/185833)

Falls die Services nicht initialisiert werden können und keine Datenbankverbindung aufgebaut werden kann oder der MailService keine E-Mails
senden kann, ist die Firewall auf die Blockierung der Ports 3306 (MySQL Standard port) und 25 (SMTP) zu überprüfen und gegebenenfalls freizugeben.
****
## Technologies

Sollten Fehler mit Maven auftreten, ist die pom.xml Datei auf Vollständigkeit zu prüfen:

### properties

source encoding : UTF-8

Compiler version: 16

### dependencies
[https://mvnrepository.com/artifact/mysql/mysql-connector-java](https://mvnrepository.com/artifact/mysql/mysql-connector-java) : version 8.0.33

[https://search.maven.org/artifact/javax.mail/javax.mail-api/1.6.2/jar](https://search.maven.org/artifact/javax.mail/javax.mail-api/1.6.2/jar) : version 1.6.2

[https://mvnrepository.com/artifact/com.sun.mail/javax.mail/1.6.0](https://mvnrepository.com/artifact/com.sun.mail/javax.mail/1.6.0) : version 1.6.2
