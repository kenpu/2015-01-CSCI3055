(ns poly-arity)

(defn echo
  ([] (println "Usage: echo <name> <message>"))
  ([m] (println m))
  ([n m] (println "My name is " n ", " m)))

(echo)
(echo "something")
(echo "Ken" "something")
