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

(deftest expand-sequences
  (testing "expand"
    (is (=
          '({\s 3} {\t 3} {\e 3} {\p 1, \f 2} {\h 1, \f 2} {\a 3} {\m 1, \n 2})
          (expand ["steffan" "stephan" "steffam"]))
          )
    )
  )

(deftest collapse-letters-1
  (testing ""
    (is (= \s (collapse {\s 2})))
    )
  )

(deftest collapse-letters-2
  (testing ""
    (is (= \s (collapse {\s 2 \c 1})))
    )
  )

(deftest collapse-letters-3
  (testing ""
    (is (= \d (collapse {\s 2 \c 1 \d 4})))
    )
  )

(deftest collapse-letters-_
  (testing ""
    (is (= \_ (collapse {\s 2 \c 1 \d 2})))
    )
  )

(deftest collapse-letters-empty
  (testing ""
    (is (nil? (collapse {})))
    )
  )

