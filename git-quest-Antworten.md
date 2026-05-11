\# Git-Quest Antworten



\## Aufgabe 1



Ich habe auf dem `master`-Branch eine Datei geändert, die im Branch `end` nicht verändert wurde (`hero.md`). Danach habe ich die Änderung committed und `origin/end` in `master` gemergt. Der Merge lief ohne Konflikt durch, weil beide Branches unterschiedliche Dateien verändert hatten.



\## Aufgabe 2



Ich habe eine Datei geändert, die auch im Branch `end` verändert wurde (`stats.md`), aber an einer anderen Stelle. Ich habe nur die Überschrift geändert. Danach konnte Git den Branch `end` automatisch mergen. Es gab keinen Konflikt, weil die Änderungen zwar in derselben Datei, aber an unterschiedlichen Stellen waren.



\## Aufgabe 3



Ich habe eine Stelle geändert, die auch im Branch `end` verändert wurde. Bei einer unterschiedlichen Änderung, zum Beispiel `sword (20 dmg)` statt `sword (3 dmg)`, entstand ein Merge-Konflikt. Git konnte nicht entscheiden, welche Version übernommen werden soll. Ich habe den Konflikt gelöst, indem ich die Konfliktmarker entfernt, eine Version behalten und die Datei danach committed habe.



\## Aufgabe 4



Ich habe zuerst auf `master` eine Änderung gemacht und committed. Danach habe ich den Branch `end` auf die Spitze von `master` gesetzt, indem ich `master` in `end` gemergt habe. Anschließend habe ich `end` wieder in `master` gemergt. Dieser letzte Merge war ein Fast-Forward, weil `end` die Änderungen von `master` bereits enthalten hatte.

