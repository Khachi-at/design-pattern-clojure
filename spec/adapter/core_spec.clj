(ns adapter.core-spec
  (:require [speclj.core :refer :all]
            [adapter.engage-switch :refer [engage-switch]]
            [adapter.variable-light :as v-l]
            [adapter.variable-light-adapter :as v-l-adapter]))

(describe "Adapter"
          (with-stubs)
          (it "turns light on and off"
              (with-redefs [v-l/turn-on-light (stub :turn-on-light)]
                (engage-switch (v-l-adapter/make-adapter))
                (should-have-invoked :turn-on-light
                                     {:times 1 :with [100]})
                (should-have-invoked :turn-on-light
                                     {:times 1 :with [0]}))))
