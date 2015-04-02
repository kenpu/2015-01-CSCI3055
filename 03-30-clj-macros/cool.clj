
(defmacro ---
  [f & args]
  (let [keys (map keyword args)
        m (apply hash-map (interleave keys args))]
    `(~f ~m)))
    


(defn make-rectangle
  [spec]
  (let [w (:width spec)
        h (:height spec)
        c (:color spec)]
    (println (format "%s (%d X %d)" c w h))))

(make-rectangle {:color "RED" :width 10 :height 5})

(let [width 10
      height 5
      color "RED"]
  (do
    (--- make-rectangle width height color)
    (--- make-rectangle width color height)
    (--- make-rectangle color height width)))

