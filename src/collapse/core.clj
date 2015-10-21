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


(defn expand
  "Expand string sequences to a vector of letters per position in those sequences.
  Then count the frequency of those letters and return them as maps.
  Example: (expand [\"abc\" \"aab\" \"abb\"]) ;; extra backlash is only for escaping
       ({\\a 3} {\\a 1, \\b 2} {\\c 1 \\b 2})
  Note: this could be replaced with the frequencies map constructing function."
  [sequences]
  (map (fn [bases] (reduce #(assoc %1 %2 (inc (%1 %2 0))) {} bases))
    (apply map vector sequences))
  )

(defn collapse
  "From a map of letters with frequency value, select the one with the highest
  frequency. If two letters have the same highest frequency, return underscore."
  [expanse]
  (loop [[lf1 lf2 & lfs] (into [] expanse)]
    (if (nil? lf2)
      (get lf1 0)  ;; get avoids NullPointerException for empty input
      (let [[[l1 f1] [l2 f2]] [lf1 lf2]]
        (if (> f1 f2)
          (recur (cons lf1 lfs))
          (if (< f1 f2)
            (recur (cons lf2 lfs))
            (recur (cons [\_ f1] lfs))
            )
          )
        )
      )
    )
  )

(defn collapseSequences
  "Collapse multiple similar strings into the most likely common ancestor"
  [sequences]
  (apply str (map collapse (expand sequences)))
  )