(ns poly-multifn)

(defmulti p type)

(defmethod p java.lang.Long
  [num]
  (println "NUMBER: ---- " num))

(defmethod p java.lang.String
  [string]
  (println "=====================")
  (println string)
  (println "====================="))

(p 42)
(p "Hello World")

(defmulti q :type)

(defmethod q :prof
  [prof]
  (println (format "%s works at %s" 
                   (prof :name)
                   (prof :room-number))))

(defmethod q :point-2d
  [point]
  (println (format "<%f, %f>"
                   (point :x)
                   (point :y))))

(q x)
(q y)











































(def x {:name "Ken"
        :room-number "UA2033"
        :type :prof})

(def y {:x 100.0
        :y 382.0
        :type :point-2d})


