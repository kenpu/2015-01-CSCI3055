(ns lecture)
(require 'clojure.pprint)

(defmacro tell
  [form]
  `(do
     (println (quote ~form))
     (print "=> ")
     (println ~form)))

(tell (+ 1 1))
; (+ 1 1)
; Result = 2
;

(clojure.pprint/pprint
  (macroexpand '(tell (doall (for [i (range 10)] i)))))
