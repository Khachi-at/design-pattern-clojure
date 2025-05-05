(ns abstract-server.core-test
  (:require [speclj.core :refer :all]
            [abstract-server.core :refer :all]))

(describe "Abstract server"
          (with-stubs)
          (it "turns light on and off"
              (with-redefs [turn-on-light (stub :turn-on-light)
                            turn-off-light (stub :turn-off-light)]
                (engage-switch {:type :light})
                (should-have-invoked :turn-on-light)
                (should-have-invoked :turn-off-light)))
          (it "turn tv on and off"
              (with-redefs [turn-on-tv (stub :turn-on-tv)
                            turn-off-tv (stub :turn-off-tv)]
                (engage-switch {:type :tv})
                (should-have-invoked :turn-on-tv)
                (should-have-invoked :turn-off-tv))))