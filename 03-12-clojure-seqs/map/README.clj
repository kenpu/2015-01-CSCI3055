; create a map
; { key val key val ... }
; (hash-map key val key val)
;
;
(def x {:name "John" :age 42})
(def y (hash-map :name "John" :age 42))

; Slightly involved way of converting
; key-list, and val-list into a hashmap
;
(def K [:name :address])
(def V ["John" "Simcoe Street"])
(apply hash-map
       (apply concat
              (map #(vector (K %) (V %))
                   (range (count K)))))
; => {:name "John", :address "Simcoe Street"}
;

; (get map key default)
(get x :address "unknown") ;=> "unknown"

; (x key default)
(x :address "unknown") ;=> "unknown"
(x :name) ;=> "John"

; (contains? x key)
;

;==============================
; (assoc one-map key val)
; returns another map by adding
; (key, val) into one-map
;
; `assoc` is used to "update" fields
; of a map.

(assoc x :age 52) ;=> {:age 52 :name "John" })

; (dissoc x key1 key2) 
; removes keys key1 key2 from x
;




