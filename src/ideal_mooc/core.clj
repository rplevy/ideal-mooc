(ns ideal-mooc.core
  (:import (existence Existence
                      Existence010
                      Existence020
                      Existence030
                      Existence031
                      Existence032
                      Existence040
                      Existence050)))

(defn java-existence [existence]
  (loop [i 0]
    (let [step-trace (.step existence)]
      (println (str i ": " step-trace))
      (Thread/sleep 500)
      (recur (inc i)))))

(defn get-other-experiment [experiment]
  (if (= experiment :e1)
    :e2
    :e1))

(defn modified-existence-20 []
  (let [interactions {[:e1 :r1] -1
                      [:e2 :r2] 1}]
    (loop [i 0
           experiment :e1
           result nil
           satisfied-duration 0
           mood nil]
      (let [experiment (if (or (= mood :pained) (= mood :bored))
                         (get-other-experiment experiment)
                         experiment)
            result (if (= experiment :e1)
                     :r1
                     :r2)
            enacted-interaction-valence (get interactions
                                             [experiment result])
            satisfied-duration (if (= mood :pleased)
                                 (inc satisfied-duration)
                                 0)
            mood (if (< enacted-interaction-valence 0)
                   :pained
                   (if (> satisfied-duration 3)
                     :bored
                     :pleased))]
        (println (str i ": " (name experiment) (name result) " " mood))
        (Thread/sleep 500)
        (recur (inc i)
               experiment
               result
               satisfied-duration
               mood)))))

(defn -main
  [& args]

  ;; (java-existence (Existence020.))

  (modified-existence-20))

