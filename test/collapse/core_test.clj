(ns collapse.core-test
  (:require [clojure.test :refer :all]
            [collapse.core :refer :all]))

(deftest isInEditDistance-1
  (testing "compare strings"
    (is (isInEditDistance "stefan" "stepan" 1))
    )
  )

(deftest is-not-in-edit-distance
  (testing "compare strings"
    (is (not (isInEditDistance "stefan" "stepam" 1)))
    )
  )

(deftest no-difference
  (testing "compare strings"
    (is (isInEditDistance "stefan" "stefan" 0))
    )
  )

(deftest empty-input
  (testing "compare strings"
    (is (isInEditDistance "" "" 0))
    )
  )

(deftest different-size-input
  (testing "compare strings"
    (is (isInEditDistance "stef" "stefan" 0))
    )
  )
