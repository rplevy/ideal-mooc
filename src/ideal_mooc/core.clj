(ns ideal-mooc.core
  (:import (existence Existence
                      Existence010
                      Existence020
                      Existence030
                      Existence031
                      Existence032
                      Existence040
                      Existence050)))
(defn -main
  "The Main Class instantiates an Existence.
   The Main Class runs the Existence step by step in a loop.
   and prints the Existence's activity as it runs."
  [& args]
  (let [existence (Existence010.)
        ;; ^^ Change this line to instantiate another existence
        ;; existence (Existence020.)
        ;; existence (Existence030.)
        ;; existence (Existence031.)
        ;; existence (Existence032.)
        ;; existence (Existence040.)
        ;; existence (Existence050.)
        ;; existence (Existence051.)

        cycles 20]
    (doseq [i (range cycles)
            :let [step-trace (.step existence)]]
      (println (str i ": " + step-trace)))))
