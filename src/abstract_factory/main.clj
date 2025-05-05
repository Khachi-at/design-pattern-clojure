(ns abstract-factory.main
  (:require [abstract-factory.shape-factory]
            [abstract-factory.shape-factory-impl :as impl]))

(def shape-factory (atom nil))

(defn init []
  (reset! shape-factory (impl/make)))
