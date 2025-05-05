(ns adapter.variable-light-adapter
  (:require [adapter.switchable :as s]
            [adapter.variable-light :as v-l]))

(defn make-adapter []
  {:type :variable-light})

(defmethod s/turn-on :variable-light [switchable]
  (v-l/turn-on-light 100))

(defmethod s/turn-off :variable-light [switchable]
  (v-l/turn-on-light 0))