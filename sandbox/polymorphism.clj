(ns oop)

(defn section [s]
  (println)
  (println s)
  (println "==============================="))


;
(section "varidic function")
;
(defn max-upto-3
  ([] (println "empty") nil)
  ([x] x)
  ([x y] (max x y))
  ([x y z] (max x y z)))

(println (max-upto-3))
(println (max-upto-3 100))
(println (max-upto-3 100 200))
(println (max-upto-3 100 200 300))
(try 
  (println (max-upto-3 100 200 300 400))
  (catch Exception e (println "exception:" e)))

;
(section "multi-method dispatching")
;
(defn make-circle
  [radius]
  {:type :circle
   :radius radius})
(defn make-rect
  [width height]
  {:type :rectangle
   :width width
   :height height})

(defmulti area :type)
(defmethod area :circle
  [data]
  (* Math/PI (Math/pow (:radius data) 2)))
(defmethod area :rectangle
  [data]
  (* (:width data) (:height data)))

(println (area (make-circle 1)))
(println (area (make-rect 10 20)))

;
(section "protocols")
;

(defprotocol IShape
  "protocol for 2D shapes"
  (get-area [this])
  (move [this dx] [this dx dy]))

; implement protocol by record
(defrecord Circle [radius]
  IShape
  (get-area [this] (* Math/PI (Math/pow (:radius this) 2)))
  (move [this dx] (println "circle move dx" dx))
  (move [this dx dy] (println "circle move dx dy" dx dy)))

(let [c (Circle. 1)]
  (println "Circle area = " (get-area c))
  (move c 0)
  (move c 0 0))

; implement protocol by reify
;

(def a-rect
  (let [width 10
        height 20]
    (reify IShape
      (get-area [this] (* width height))
      (move [this dx] (println "rect move" dx))
      (move [this dx dy] (println "rect move" dx dy)))))

(println "Rect area = " (get-area a-rect))
(move a-rect 0)
(move a-rect 0 0)

; implement a protocol by extend
;
(defrecord Triangle [base height])

(extend-type Triangle
  IShape
  (get-area [this] (/ (* (:base this) (:height this)) 2))
  (move [this dx] (println "triangle move dx" dx))
  (move [this dx dy] (println "triangle move dx dy" dx dy)))

(println "Triangle area = " (get-area (Triangle. 10 20)))

