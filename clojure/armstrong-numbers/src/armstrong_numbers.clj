(ns armstrong-numbers
    (:require [clojure.math.numeric-tower :as math]))

(defn -num-to-digits
      [num]
      (map
        #(rem % 10)
        (take-while
          (partial < 0)
          (iterate #(quot % 10) num))))

(defn -sum-of-digits-raised-to-power-of-num-of-digits
      [num-as-digits]
      (let [power (count num-as-digits)]
           (apply + (map #(math/expt % power) num-as-digits))))

(defn armstrong?
      [num]
      (let [num-as-digits  (-num-to-digits num)]
           (= num (-sum-of-digits-raised-to-power-of-num-of-digits num-as-digits))))

;; checked the test cases and saw there was one specifically stating "There are no 2 digit Armstrong numbers"
;; proof:
;; any 2 digit number will be 1^2 (1) + X^2
;; 1 + X^2 == X
;; X^2 == X - 1
;; X == √(X - 1) !!
