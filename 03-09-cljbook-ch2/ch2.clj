; Different values in Clojure
;

(println 42)        ; simple number

(println [1 2 3])   ; [ ... ] is a vector - think of it like an array

; s-expression being evaluated
(println (+ 1 2 3 4 5 6))

; putting together two "arrays"
(println (concat [1 2] [3 4]))

; ===========================================
(println "starting at page 25")

(println 'hello)
(println "
         This is a very nice block
         of text, and we don't have to worry
         about spanning over multiple lines.
         ")

(println (str 123 "," 'hello-world))

; =========================================
(println "about name binding")
(def array ["hello" "," "world" "," 1 "," 2 "," 3])
(println array)

; =========================================
; Touching on macros...
;
(println "page 27")

(println (str ["hello" "world" 1 2 3]))
(println (str "hello" "world" 1 2 3))

(println (str array))
; rely on `apply` to execute the s-expression of the form
; (str "hello" "," "world" "," 1 "," 2 "," 3)
(println (apply str array))

; ======================================
; True or false
(println "true? \"\"" (true? ""))
(println "false? \"\"" (false? ""))

(println "true? true" (true? true))
(println "false? false" (false? false))

(println "true? nil" (true? nil))
(println "false? nil" (false? nil))

; if-else expressions
; (if <bool-expr> <expr1> <expr2>)
(println
  (if (> (count array) 2)
    "array has more than two things"
    "array has less than two things"))

; =====================================
; Maps
;
(println "\n\nMaps")

(def inventor {"Lisp" "John", "Clojure" "Rich"})
(println inventor)
(println "Lisp is invented by" (inventor "Lisp"))
(println "C++ is invented by" (inventor "C++"))
(println "C++ is invented by" 
         (if (nil? (inventor "C++")) "NO ONE" (inventor "C++")))
(println "C++ is invented by" (get inventor "C++" "NO ONE"))

; Keywords
; :<keyword-name>

(println :hello :world)

(def inventor {:lisp "John" :clojure "Rich"})
(println "Clojure is invented by" (inventor :clojure))
(println "Clojure is invented by" (:clojure inventor))

; when to use :clojure as a function to fetch value from map
(defn build-big-map []
  {:clojure [1 2 3]
   :c++     [\d \e \f]})

(println (apply str ((build-big-map) :c++)))
(println (apply str (:c++ (build-big-map))))

; ==========================================
(println "\n\nPage 33")
(defn add [a b]
  (+ a b))

(println "10 + 20" (add 10 20))

(defn repeat-n-times [n f a b]
  (dotimes [i n]
    (println "Iteration" i "," (f a b))))

(repeat-n-times 4 add 1000 2000)

(repeat-n-times 5 (fn [a b] (* a b)) 1000 2000)

(repeat-n-times 5 #(- %1 %2) 1000 2000)

; ============================================
; (let [symbol1 <expr1>, symbol2 <expr2>,  ...] <subexpr1> <subexpr2> ...)
(println "\n\nLet expressions")
(let [x 100
      y 200]
  (println "100 + 200 = " (add x y)))

