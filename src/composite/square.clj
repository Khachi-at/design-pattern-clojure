(ns composite.square
  (:require [clojure.spec.alpha :as s]
            [composite.shape :as shape]
            [composite.square :as square]))

(s/def ::top-left (s/tuple number? number?))
(s/def ::side number?)
(s/def ::square (s/keys :req [::shape/type
                              ::side
                              ::top-left]))

(defn make-square [top-left side]
  {:post [(s/valid? ::square %)]}
  {::shape/type ::square
   ::top-left top-left
   ::side side})

(defmethod shape/translate ::square [square dx dy]
  {:pre [(s/valid? ::square square)
         (number? dx) (number? dy)]
   :post [(s/assert ::square %)]}
  (let [[x y] (::top-left square)]
    (assoc square ::top-left [(+ x dx) (+ y dy)])))

(defmethod shape/scale ::square [square factor]
  {:pre [(s/valid? ::square square)
         (number? factor)]
   :post [(s/valid? ::square %)]}
  (let [side (::side square)]
    (assoc square ::side (* side factor))))

(defmethod shape/to-string ::square [square]
  {:pre [(s/valid? ::square square)]
   :post [string? %]}
  (let [{:keys [::top-left ::side]} square
        [x y] top-left]
    (format "Square top-left: [%s,%s] side: %s" x y side)))
