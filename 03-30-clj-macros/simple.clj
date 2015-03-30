(ns simple)
(use 'clojure.pprint)

(defn f [forms]
  (let [once (map #(list 'println %) forms)]
    (interleave once once)))

(defmacro show-twice
  [& forms]
  (cons 'do (f forms)))

(clojure.pprint/pprint
  (macroexpand 
    '(show-twice 
      (+ 1 1)
      (+ 10 10)
      (* 10 10))))

(show-twice
  (+ 1 1)
  (+ 10 10)
  (* 10 10))
