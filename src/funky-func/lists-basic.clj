(ns funky-func.lists-basic)

;; Basic about lists
;; The goal of these tasks is to:
;; - get used to working with lists in Clojure
;; - become familiar with some basic procedures that
;;   will make it easier to perform more advanced operations on lists.

;; Those who have worked with Java/Python/C will be used to solving problems
;; using loops. Clojure does not have loops, so we need to use procedures
;; (iterative and recursive) to solve problems instead.
;; This is not a limitation: anything you can do with loops you can also
;; do with procedures.

;; == Iterative and recursive processes ==
;; When solving the tasks, consider whether your solution results in a recursive
;; or iterative process, and try to think if it makes sense to write a solution
;; that uses the other type of process.

;; Some procedures for working on lists are built into Clojure, such as `count` and `reverse`.
;; The procedures you are asked to write are not built-in, but are commonly
;; built-in in other languages, and especially in functional languages like Haskell, Clojure,
;; and Racket, these procedures will be widely used.

;; ---------------------------------------------
;; First, a practical procedure since we want to be able to test our procedures on lists.
(defn range [from to]
  'not-implemented)

(range 1 10)        ; => (1 2 3 4 5 6 7 8 9 10)

;; ---------------------------------------------
;; Write the procedure 'take' which retrieves the first n elements of a list.
;; If the list is smaller than 'n', the entire list is returned.
(defn take [n items]
  'not-implemented)

(take 5 '(1 2 3 4 5 6 7 8 9 10)) ; => (1 2 3 4 5)
(take 5 '(1 2 3))                ; => (1 2 3)
(take 0 '(1 2 3))                ; => ()
(take 5 '())                     ; => ()

;; ---------------------------------------------
;; Write a procedure 'drop' which returns a list without the first n elements.
;; If there are fewer than 'n' elements in the list, the empty list is returned.
(defn drop [n items]
  'not-implemented)

(drop 5 '(1 2 3 4 5 6 7 8 9 10)) ; => (6 7 8 9 10)
(drop 5 '(1 2 3))                ; => ()
(drop 0 '(1 2 3))                ; => (1 2 3)
(drop 5 '())                     ; => ()

;; Note that (concat (take n items) (drop n items)) == items
;; ---------------------------------------------
;; Write a procedure 'init' which returns a list without the last element.
;; You can assume that the list contains at least one element.
;; This is somewhat the opposite procedure of 'last'
(defn init [items]
  'not-implemented)

(init '(1 2 3 4 5 6 7 8 9 10)) ; => (1 2 3 4 5 6 7 8 9)
(init '(1 2 3))                ; => (1 2)

;; ---------------------------------------------
;; Write a procedure 'last' which returns the last element in a list.
;; You can assume that the list contains at least one element.
(defn last [items]
  'not-implemented)

(last '(1 2 3 4 5 6 7 8 9 10)) ; => 10
(last '(1 2 (3 4 5)))          ; => (3 4 5)
(last '(1 (2 3) '()))           ; => ()

;; ---------------------------------------------
;; Write a procedure 'nth' which returns the nth element in a list.
;; You can assume that the list contains at least one element.
(defn nth [n items]
  'not-implemented)

(nth 5 '(1 2 3 4 5 6 7 8 9 10)) ; => 6
(nth 2 '(1 2 '(3 4 5)))          ; => (3 4 5)
(nth 2 '(1 '(2 3) '()))          ; => ()

;; ---------------------------------------------
;; Below are some built-in procedures that you reimplement for practice.
;; The names are slightly changed to avoid naming conflicts.

;; Write your own version of 'append'. The built-in version can take a variable number of lists
;; as input, but you can write a version that only takes two lists.
(defn my-append [items1 items2]
  'not-implemented)

(my-append '(1 2 3) '(4 5 6)) ; => (1 2 3 4 5 6)
(my-append '() '(4 5 6))      ; => (4 5 6)
(my-append '(1 2 3) '())      ; => (1 2 3)
(my-append '() '())           ; => ()

;; If you have implemented a variadic variant:
;; (my-append '(1 2 3) '(4 5 6) '(7 8 9)) ; => (1 2 3 4 5 6 7 8 9)

;; ---------------------------------------------
;; Write your own version of 'length'.
(defn my-length [items]
  'not-implemented)

(my-length '())                 ; => 0
(my-length '(1 2 3))            ; => 3
(my-length '(1 (2 3 4) 5 6))    ; => 4

;; ---------------------------------------------
;; Write your own version of 'reverse'
(defn my-reverse [items]
  'not-implemented)

(my-reverse '())                ; => ()
(my-reverse '(1 2 3 4 5))       ; => (5 4 3 2 1)
(my-reverse '(1 (2 3) (4 5)))   ; => ((4 5) (2 3) 1)

;; ---------------------------------------------
;; Below are some exercises. Feel free to write solutions both with and without
;; the procedures you have written above to see the difference.

;; -----------------------------------
;;

;; Slice extracts a portion of the list, from the element at index 'start'
;; to the element at index 'end'.

(defn slice [start end items]
  'not-implemented)

(slice 3 7 '(0 1 2 3 4 5 6 7 8 9 10))  ; (3 4 5 6 7)
(slice 3 70 '(0 1 2 3 4 5 6 7 8 9 10))  ; (3 4 5 6 7 8 9 10)

;; Find the second last element in a list. Here, you can assume that there are
;; at least two elements in the list.

(defn second-last [items]
  'not-implemented)

(second-last '(1 2 3 4 5))  ; 4
(second-last '(a b))         ; a

;; Determine whether a list is a palindrome, i.e., whether the list is the same
;; forwards and backwards.

(defn palindrome? [items]
  'not-implemented)

(palindrome? '())                   ; true
(palindrome? '(hallo))              ; false
(palindrome? '(1 2 3 2 1))          ; true
(palindrome? '(1 2 3 4 5))          ; false
(palindrome? '((1 2) (3 4) (1 2)))  ; true (each inner list is counted as a separate element.)

;; Write a procedure that inserts an element at a given position in a list.
;; You can choose what to do if the list is shorter than the position the element
;; is to be inserted at.

(defn insert-at [n item items]
  'not-implemented)

(insert-at 3 3 '(0 1 2 4 5 6))  ; (0 1 2 3 4 5 6)
(insert-at 5 'f '(a b c d e))   ; (a b c d e f)
