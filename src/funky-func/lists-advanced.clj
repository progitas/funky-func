(ns funky-func.lists-advanced)

;; Here you can (and should!) naturally use the procedures you have written earlier.
(load "basic-lists.scm")

;; More advanced procedures and tasks on lists

;; In this exercise set, the tasks are somewhat more advanced, and several of the procedures
;; are higher-order procedures. That means they either take a procedure as an argument,
;; or return a procedure, or both.

;; As in the previous exercise set, you will often have the opportunity to
;; use the earlier procedures in the tasks below.

;; -----------------------------------

;; First, let's write a procedure 'range' that allows us to create lists.
;; This makes it easy to test our code.

(defn range [from to]
  (if (> from to)
      '()
      (cons from (range (inc from) to))))

;; -----------------------------------

;; Since filter and reduce are not built-in, we start by defining them.
;; This may be repetitive for some, but it should be familiar!

(defn filter [pred items]
  'not-implemented)

(filter even? '(1 2 3 4 5 6 7 8 9))                     ; (2 4 6 8)
(filter odd? '(1 2 3 4 5 6 7 8 9))                      ; (1 3 5 7 9)
(filter #(= % 'a) '(a b c a e f a g))                   ; (a a a)

;; -----------------------------------

(defn reduce [proc def items]
  'not-implemented)

;; You have defined range in basic-lists.scm.
(reduce + 0 (range 1 100))      ; 5050
(reduce * 1 (range 1 10))       ; 3628800
(reduce cons '() (range 1 10))  ; (1 2 3 4 5 6 7 8 9 10)

;; -----------------------------------

;; Write the procedure 'take-while' that finds all the elements from the start of a
;; list that satisfy a predicate.

(defn take-while [pred items]
  'not-implemented)

(take-while even? '(2 4 6 8 10 11 12 13 14 15))     ; (2 4 6 8 10)
(take-while odd? '(2 4 6 8 10 11 12 13 14 15))      ; ()
(take-while #(> 10 %) '(5 8 10 7 3))                ; (5 8)
(take-while #(<= 100 (* % %))
            '(2 4 6 8 10 11 12 13 14 15))           ; (2 4 6 8 10)

;; -----------------------------------

;; Write the 'drop-while' procedure that discards all the elements from the start of a
;; list that satisfy a predicate. Once an element no longer satisfies the predicate,
;; return the rest of the list.

(defn drop-while [pred items]
  'not-implemented)

(drop-while even? '(2 4 6 8 10 11 12 13 14 15))     ; (11 12 13 14 15)
(drop-while odd? '(2 4 6 8 10 11 12 13 14 15))      ; (2 4 6 8 10 11 12 13 14 15)
(drop-while #(> 10 %) '(5 8 10 7 3))                ; (10 7 3)
(drop-while #(<= 100 (* % %))
            '(2 4 6 8 10 11 12 13 14 15))           ; (11 12 13 14 15)

;; -----------------------------------

;; 'group-by' collects all elements that return the same value
;; when called with the procedure. This means the list is split every time
;; the procedure returns a different value than it did on the previous value.
(defn group-by [pred items]
  'not-implemented)

(group-by even? '(1 1 2 2 3 3))				    ; -> ((1 1) (2 2) (3 3))
(group-by even? '(1 3 5 2 4 6 12 13 14 15))     ; -> ((1 3 5) (2 4 6 12) (13) (14) (15))
(group-by #(mod % 3)
          '(0 3 6 9 4 7 8 5))                   ; -> ((0 3 6 9) (4 7) (8 5))

;; -------------

;; Assuming group-by is correct, we get 'group' for free:
;; 'group' groups similar values together.
(defn group [items]
  (group-by '?? items))

(group '(1 1 2 2 3 3))				; -> ((1 1) (2 2) (3 3))
(group (range 1 10))                ; -> ((1) (2) (3) (4) (5) (6) (7) (8) (9) (10))
(group '(a a b c c d d))            ; -> ((a a) (b) (c c) (d d))

;; -------------

;; Convert all collections of the same value in a list to just one value.
;; Here, 'group' should come in handy!
(defn compress [items]
  'not-implemented)

(compress '(1 1 2 2 3 3))				; -> (1 2 3)
(compress '(1 1 1 1 1 1 1 1 1 1))		; -> (1)
(compress '(1 2 3 4 5 6 7 8 9 10))		; -> (1 2 3 4 5 6 7 8 9 10)
(compress '(a b c d d e f g g h h i))	; -> (a b c d e f g h i)
(compress '(1 2 3))                     ; -> (1 2 3)
