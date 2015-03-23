(ns learn-proto)

(println "=== Learn Protocol in Clojure ===")

;
; Create a few protocols
;
(defprotocol Shape
  (area [shape]
    "computes the area of a shape"))

(defprotocol Movable
  (move [obj dx dy] 
        "moves the object 
        with relative displacement")
  (move-to [obj x y]
           "moves the object with absolute
           displayment"))

(defprotocol Display
  (p [obj name] "prints the object to console"))

;
; Provide some implementations of the protocols
;

(deftype Rectangle [width height corner]
  Shape
  (area [shape]
    (* (.width shape) (.height shape)))
  Movable
  (move-to [shape x y]
    (let [w (.width shape)
          h (.height shape)]
      (Rectangle. w h [x y])))
  (move [shape dx dy]
    (let [c (.corner shape)]
      (move-to shape 
               (+ dx (c 0))
               (+ dy (c 1)))))
  Display
  (p [shape name]
    (println name)
    (println (format "%d X %d @ (%s)"
                     (.width shape)
                     (.height shape)
                     (str (.corner shape))))))

(def my-rect (Rectangle. 10 20 [100 100]))
(println "Width =" (.width my-rect))
(println "Height =" (.height my-rect))
(println "Corner =" (.corner my-rect))
(println "Area =" (area my-rect))

(println "========= move it =========")
(let [your-rect (move my-rect 4 5)
      her-rect (move-to my-rect 30 40)]
  (p your-rect "Your rectangle")
  (p her-rect "Her rectangle"))


(println "=========== Circle =============")
(deftype Circle [radius center])

(extend-type Circle
  Shape
  (area [circle]
    (* Math/PI (.radius circle) (.radius circle))))

(extend-type Circle
  Display
  (p [circle name]
    (println name)
    (println (format "circle: R = %d @ %s"
                     (.radius circle)
                     (str (.center circle))))))

(let [c (Circle. 10 [0 0])]
  (p c "A circle")
  (println "Area=" (area c)))

;
; No types whatsoever
;
(println "=========== Blob =============")
(defn weird-thing [cljmap]
  (let [a (:a cljmap)
        b (:b cljmap)
        c (:c cljmap)]
    (reify
      Shape
      (area [shape]
        (+ (Math/sin a) b (* 2 c)))
      Display
      (p [shape name]
        (println name)
        (println (format "%s --- %s --- %s"
                         a b c))))))

(let [blob (weird-thing {:a 0.5 :b 1 :c 2})]
  (p blob "Bob the Blob")
  (println "Area =" (area blob)))


