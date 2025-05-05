(ns abstract-server.core)

(defn turn-on-light []
  ; turn on the bloody light!
  )

(defn turn-off-light []
  ; Criminy! just turn it off!
  )

(defn turn-on-tv []
  ; turn on the tv
  )

(defn turn-off-tv []
  ; just turn tv off.
  )

(defmulti turn-on :type)
(defmulti turn-off :type)

(defmethod turn-on :light [switchable]
  (turn-on-light))

(defmethod turn-off :light [switchable]
  (turn-off-light))

(defmethod turn-on :tv [switchable]
  (turn-on-tv))

(defmethod turn-off :tv [switchable]
  (turn-off-tv))

(defn engage-switch [switchable]
  ;Some other stuff...
  (turn-on switchable)
  ;Some more other stuff..
  (turn-off switchable))