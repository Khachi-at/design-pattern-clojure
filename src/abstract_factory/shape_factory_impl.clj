(ns abstract-factory.shape-factory-impl
  (:require [abstract-factory.shape-factory :as factory]
            [composite.square :as square]
            [composite.circle :as circle]))

(defn make []
  {::factory/type ::implementation})


(defmethod factory/make ::implementation
  [factory type & args]
  (condp = type
    :square (apply square/make-square args)
    :circle (apply circle/make-circle args)))