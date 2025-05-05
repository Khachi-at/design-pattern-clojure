(ns decorator.journaled-shape-spec
  (:require [decorator.journaled-shape :as js]
            [speclj.core :refer :all]
            [composite.square :as square]
            [composite.shape :as shape]))

(describe "journaled shape decorator"
          (it "journals scale and translate operations"
              (let [jsd (-> (js/make (square/make-square [0 0] 1))
                            (shape/translate 2 3)
                            (shape/scale 5))]
                (should= [[:translate 2 3] [:scale 5]]
                         (::js/journal jsd))
                (should= {::shape/type ::square/square
                          ::square/top-left [2 3]
                          ::square/side 5}
                         (::js/shape jsd)))))