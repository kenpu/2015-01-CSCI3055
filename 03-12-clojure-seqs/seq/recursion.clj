(ns recursion)

(def numbers (range 100))

(def squares 
  (for [n numbers :when (zero? (mod n 2)) :while (< (* n n) 6000)]
        [n (* n n)]))

(println squares)

(println "------------------------------")

; compute squares with recursion

(defn compute-squares
  "take [numbers] and returns a list ([n n^2])"
  [numbers]
  (if (empty? numbers) 
    nil
    (let [n       (first numbers)
          numbers (rest numbers)]
      (if (> (* n n) 6000)
        nil
        (if (even? n)
          (cons [n (* n n)] (compute-squares numbers))
          (compute-squares numbers))))))

(println (compute-squares numbers))

(println "---------------------------------")

(def squares-2
  (let [sq #(vector % (* % %))]
    (take-while #(< (% 1) 6000) (map sq (filter even? numbers)))))

(println squares-2)

