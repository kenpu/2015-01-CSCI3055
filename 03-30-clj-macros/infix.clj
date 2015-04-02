(ns infix)
(require 'lecture)

(defmacro --
  [a op b]
  (list op a b))

(lecture/tell (+ 1 1))
(lecture/tell (-- 1 + 1))

