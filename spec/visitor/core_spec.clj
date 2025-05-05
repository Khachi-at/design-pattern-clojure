(ns visitor.core-spec
  (:require [speclj.core :refer :all]
            [visitor.json-shape-visitor :as jv]
            [composite.square :as square]
            [composite.circle :as circle]
            [visitor.json-shape-visitor-impl]))

(describe "shape-visitor"
          (it "makes json square"
              (should= "{\"top-left\": [0,0], \"side\": 1}"
                       (jv/to-json (square/make-square [0 0] 1))))
          (it "make json circle"
              (should= "{\"center\": [3,4], \"radius\": 1}"
                       (jv/to-json (circle/make-circle [3 4] 1)))))