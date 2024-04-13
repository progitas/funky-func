# Funky func
> En god gammeldags, skamløst stjålet, og helt basic gruppetime om LISP-språk.

## 0. Q&A

**Hvorfor holder jeg WS i dette?**

Jeg hadde et fag om funksjonell programmering med Scheme på IFI i 2019 og syntes det var kult. (Jeg var og betalt eksamensretter i samme fag (med all troverdighet det medfører;-))

**Hvilket språk skal vi prøve oss på i dag?**

Clojure

**Kan jeg Clojure?**

Nei. Men jeg var helt rå i Scheme i 2019, og Lisp er vel Lisp, såååå dette bør gå bra!

**Hvorfor tar vi Clojure da?**

Clojure har store bibliotek og kjører på JVM, som gjør det mer egnet for prosjekter og skalering. I motsetning er Scheme en minimalistisk Lisp-variant. Til gjengjeld gjør det Scheme til et språk velegnet for å lære Lisp-basics, men i det store og det hele er Clojure mer anvendelig og har et bredere miljø.

Clojure krever også lite installasjon, og kan kjøres i terminal og vanlig IDE, mens det jeg vet om av Scheme er at man må laste ned et forhistorisk REPL (Dr.Racket) som er en editor/REPL for evaluering av Scheme.

Men mest fordi jeg har hatt lyst til å lære Clojure da, så hvilken bedre mulighet enn denne.

## 1. Funksjonell programmering -> Lisp -> Clojure (2 min)

**Basics**

- Deklarativt: Prosedyrer forteller hva som skal gjøres, ikke hvordan
- Ingen sideeffekter
- Prosedyrer gir alltid samme resultat

**Daglig bruk**

- Å bruke funksjonelle prinsipper gir god forutsigbarhet og lesbarhet i koden man skriver
- De fleste språk har bra innebygd støtte for å bruke funksjonelle prosedyrer
- Map/ Filter/ Reduce er kjent for mange, og er funksjonelle prosedyrer som lar deg iterere over og manipulere data uten å mutere.

**Lisp** 

- Høynivå språk med flere dialekter (Scheme, Clojure, Emacs Lisp, Common Lisp etc.)
- Støtter også objektorientert, og har støtte for "destruktive operasjoner", men er godt egnet for å skrive rent funksjonelt likevel
- Matematisk tankegang, og man kan gjerne kjenne igjen paranteser

**REPL**

Utviklingen skjer i REPL. Det er et shell, der man kan kjøre og evaluere enkeltlinjer med kode hver for seg . For hver prosedyre man kjører, kan man evaluere den enkeltprosedyren for å sjekke at alt kjører og evaluerer som forventet - uten å sette opp et helt program først.

## 2. Lisp -> Syntaks (3 min)

**Parenteser**

"Alt" i Lisp er bygget opp inni parenteser som utgjør lister av verdier > "Parentesbasert prefiksnotasjon" < som i praksis betyr at vi skriver Lisp i form av lister. Den første verdien i lista antas å være en funksjon, mens resten er argumenter.

Gjerne gjenkjennbart fra matematikk (bortsett fra plasseringen av funksjonskallet), og når man nøster parenteser blir den innerste parentesen evaluert først.

```clojure
;;  func   params
(    +      1 2) ;; -> 3

;; Prefix lister med apostrof leser uten å evaluere uttrykket
'(1 2 3) ;; -> (1 2 3)
'hallo ;; -> hallo
```

**Lister og vektorer**

```clojure

;; Definer vanlige listestrukturer ≈ LinkedList
'(1 2) ;; -> (1 2)

;; Vektorer ≈ ArrayList
[1 2]

;; Legg til et tall i begynnelsen av en liste
(cons 3 '(1 2)) ;; -> (3 1 2)
```

**Conditionals**

```clojure
(if (= 1 2) 'Likt 'Ulikt) ;; -> Ulikt
(when true 'Kjør) ;; -> Kjør
```

**Prosedyredefinisjoner**

```clojure
;;     name            params      body
(defn  hello-world    [person]    (str "Hello" person)))

(hello-world "Ingeborg") ;; -> Hello Ingeborg
```

**Innebygde funksjoner**

Det finnes innebygde funksjoner for veldig mye!

```clojure
(first [1 2 3]) ;; -> 1
(last [1 2 3]) ;; -> 3

;; osv osv, the sky's the limit! Og så er det og mulig å definere egne makroer, men det kan jeg ikke så mye om...
```

## 3. Setup

Enkel Mac installering (utfyllende info [her](https://github.com/iterate/mikrobloggeriet/blob/master/clojure-quickstart-homebrew.md), TLDR under)
```bash
brew install clojure/tools/clojure

# For nicere terminal-basert REPL
brew install rlwrap

# Start REPL
clj
```
Masse feilmeldinger? Kanskje du ikke har JVM: `brew install --cask temurin`

Jeg håper også denne funker: [Installeringsguide for Windows](https://gist.github.com/bpringe/4f1d07f98633a956a8b33af572e7b810). Visstnok skal det bare være:
```bash
choco install lein

# Start REPL
lein repl
```

Test om alt er good med din første(?) clojure-kommando:
```clojure
(+ 1 2) ; -> 3
```

Anbefaler å bruke VSCode videre, og da er [Calva](https://calva.io/) en nice plugin for å bruke REPL i VSCode. Det gir både formattering og kjøring av kode.

## 4. Oppgaver

Her kommer den skamløse stjelinga. Faget jeg hadde i 2019 ga veldig god intro til Lisp, så hvorfor finne opp hjulet på nytt? Jeg har skrevet om noen oppgavefiler derfra til Clojure, som går ut på å bygge opp funksjoner for å jobbe med lister i funksjonell rekursjon :-)

Med Calva i VSCode kan dere og begynne med ">Fire up the Getting Started REPL" som inneholder en walkthrough av litt Calva- og Clojure-funksjonalitet.

> Disclaimer: Disse oppgavene er altså laget for Scheme, som er mer lettvekts enn Clojure. Clojure har mye av de funksjonene som bygges i oppgavene innebygd. Men det gir likevel god språkforståelse å bygge det opp, og dette er jo som kjent en god gammeldags gruppetime, såååå kjørrr!

Så for å begynne oppgavene, starter vi enkelt inni repoet: åpne en fil og bare kjør kommandoen ">Start a Project REPL and Connect" > deps.edn. Vi har følgende filer:

1. intro.clj
2. lists-basic.clj
3. lists-advanced.clj

Hvis dette ikke fungerer i det hele tatt, så har jeg heldigvis en backup: **Vil du heller gjøre litt funksjonelle nøtter i et valgfritt språk?**
No prob, Hacker Rank har en hel haug i ulik vanskelighetsgrad [her](https://www.hackerrank.com/domains/fp)!

**Ta det videre**
- [Clojure for the Brave and True](https://www.braveclojure.com/) skal være en bra bok
- [Poetry of Programming](https://egri-nagy.github.io/popbook/)
