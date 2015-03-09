; IF-ELSE
(println 
  (if true 
    "THIS IS GOOD" 
    "THIS IS BAD"))

; NO for-loop (as we know it in Java),
; NO while-loops (not really)

; do it with recursion
; this does not scale
(defn sum0
  [n]
  (if (zero? n)
    0
    (let [s (+ n (sum0 (- n 1)))]
      s)))

(defn sum1
  [n]
  (loop [s 0 
         i 0]
    (if (> i n)
      s
      (recur (+ s i) (inc i)))))

(println (sum1 1000000))

; slight short-hand

(defn sum2 [n]
  (let [f (fn [n s]
            (if (zero? n)
              s
              (recur (dec n) (+ n s))))]
    (f n 0)))

(println (sum2 1000000))

