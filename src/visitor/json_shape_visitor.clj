(ns visitor.json-shape-visitor
  (:require [composite.shape :as shape]))

(defmulti to-json ::shape/type)

