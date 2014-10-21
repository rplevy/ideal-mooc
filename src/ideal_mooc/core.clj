(ns ideal-mooc.core
  (:import (existence Existence
                      Existence010
                      Existence020
                      Existence030
                      Existence031
                      Existence032
                      Existence040
                      Existence050)))

(defn run-java-existence [existence]
  (loop [i 0]
    (let [step-trace (.step existence)]
      (println (str i ": " step-trace))
      (Thread/sleep 500)
      (recur (inc i)))))

(defn -main
  [& args]
  (run-java-existence (Existence020.)))

