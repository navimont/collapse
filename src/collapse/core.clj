(ns collapse.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn reduceDistance
  ""
  [pairs remainingDistance]
  (if (< remainingDistance 0)
    false
    (if (empty? pairs)
      true
      (let [[p1 p2] (first pairs) pr (rest pairs)]
        (if (= p1 p2)
          (reduceDistance pr remainingDistance)
          (reduceDistance pr (- remainingDistance 1))
          )
        )
      )
    )
  )

(defn isInEditDistance
  "Check edit distance of two strings"
  [str1 str2 maxDist]
  (reduceDistance (map vector str1 str2) maxDist)
  )

