; Building a list

'(\a \b \c)

; ^^ the quote prevents evaluation of the list as a s-expression.
;

(list \a \b \c)

;============================
; first and rest
; `first` 

(def x (list 1 2 3))

(first x) ;=> 1
(rest x)  ;=> '(2 3)

; ============================
; conj: adds elements to the head
; of a list
;
(conj x \a \b \c) ;=> (\c \b \a 1 2 3)
; cons: adds element to the head of a list
;
(cons \a x) ;=> (\a 1 2 3)

; concat: puts a bunch of lists together into one big long list
;
(concat '(\a \b \c) x) ;=> (\a \b \c 1 2 3)



