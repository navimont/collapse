(ns collapse.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn isInEditDistance
  "Verify edit distance between two strings"
  [str1 str2 maxDist]
  (loop [pairs (map vector str1 str2) remainingDist maxDist]
    (if (< remainingDist 0)
      false
      (if (empty? pairs)
        true
        (let [[p1 p2] (first pairs)]
          (if (= p1 p2)
            (recur (rest pairs) remainingDist)
            (recur (rest pairs) (dec remainingDist))
            )
          )
        )
      )
    )
  )

(defn collapse
  "Collapse multiple similar strings into the most likely common ancestor"
  [sequences]
  (apply map vector sequences)
  )
