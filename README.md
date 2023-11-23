# AutoVerwaltung
Dieses Projekt dient dem Training der Grundlagen in der Software-Entwicklung.
Dieses Projekt soll folgende Features anbieten: 
* Hinzufügen eines Autos in die AutoVerwaltung
* Löschen eines Autos aus der AutoVerwaltung
* Anzeigen der aktuell verfügbaren Autos in der AutoVerwaltung
* Die AutoDaten eines Autos können aktualisiert werden

[User-Story Auto registrieren]Als Manager der AutoVerwaltung möchte ich, dass neue Autos beim Hinzufügen in die AutoVerwaltung registriert werden müssen, damit diese automatisiert verifiziert werden können.
* Bei der Registrierung muss eine gültige E-Mail-Adresse und die AutoDaten angegeben werden
* Es wird eine UUID an die angegebene E-Mail-Adresse verschickt
* Damit ein Auto in die AutoVerwaltung aufgenommen werden kann, müssen E-Mail-Adresse und Verifizierungscode übergeben werden
* Der Verifizierungscode verliert nach 24 Stunden seine Gültigkeit


Abbildung auf DDD Mustersprache und Klassen

Applicationservice: AutoVerwaltung
ValueObject: E-Mail-Adresse, AutoDaten, VerifizierungsCode
Aggregate: RegistrierungsDaten
Repository: RegistrierungsDatenRepository
DomainEvent: VerifizierungsCodeVerschickt