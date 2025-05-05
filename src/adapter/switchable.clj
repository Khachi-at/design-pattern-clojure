(ns adapter.switchable)

(defmulti turn-on :type)
(defmulti turn-off :type)