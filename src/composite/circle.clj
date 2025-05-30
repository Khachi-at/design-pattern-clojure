(ns composite.circle
  (:require [clojure.spec.alpha :as s]
            [composite.shape :as shape]
            [composite.circle :as circle]))

(s/def ::center (s/tuple number? number?))
(s/def ::radius number?)
(s/def ::circle (s/keys :req [::shape/type
                              ::radius
                              ::center]))

(defn make-circle [center radius]
  {:post [(s/valid? ::circle %)]}
  {::shape/type ::circle
   ::center center
   ::radius radius})


(defmethod shape/translate ::circle [circle dx dy]
  {:pre [(s/valid? ::circle circle)
         (number? dx) (number? dy)]
   :post [(s/valid? ::circle %)]}
  (let [[x y] (::center circle)]
    (assoc circle ::center [(+ x dx) (+ y dy)])))

(defmethod shape/scale ::circle [circle factor]
  {:pre [(s/valid? ::circle circle)
         (number? factor)]
   :post [(s/valid? ::circle %)]}
  (let [radius (::radius circle)]
    (assoc circle ::radius (* radius factor))))


(defmethod shape/to-string ::circle [circle]
  {:pre [(s/valid? ::circle circle)]
   :post [(string? %)]}
  (let [{:keys [::center ::radius]} circle
        [x y] center]
    (format "Circle center: [%s,%s] radius: %s" x y radius)))