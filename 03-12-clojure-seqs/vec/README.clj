; Build a vector
; [1 2 3]
; or use (vector 1 2 3)

(def x [1 2 3])

; Convert a list to a vector
(let [a-list (list 1 2 3)]
  (vec a-list)) ;=> [1 2 3]

; first and rest acts on vector as well
; *note*: they return lists

(first x) ; => 1
(rest x) ; => (2 3)

; conj acts weird...
;
(conj x \a) ; => (1 2 3 \a)
(cons \a x) ; => (\a 1 2 3)

; peek returns the top element
; pop returns the vector with the top element removed
(peek x) ;=> 3
(pop x) ;=> [1 2]

(into [\a \b \c] x) ;=> [\a \b \c 1 2 3]

; ========================
; Unique to vector
;
; (get vec index)
(get x 2) ;=> 3
(get x 10) ;=> nil

(x 2) ;=> 3
(x 10) ;=> IndexOutofBoundsException

(subvec x 1 3) ;=> [2 3]



