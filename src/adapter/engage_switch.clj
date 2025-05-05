(ns adapter.engage-switch
  (:require [adapter.switchable :as s]))

(defn engage-switch [switchable]
  ;Some other stuff...
  (s/turn-on switchable)
  ; Some more other stuff..
  (s/turn-off switchable))