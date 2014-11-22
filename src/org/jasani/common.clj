(ns org.jasani.common)

(defn pff
  "Behave like printf should, but doesn't.

   Prints formatted text using *flush-on-newline* policy
   for buffer flushing."
  [fmt & args]
  (let [s (apply format fmt args)
        i (.indexOf s "\n")]
    (print s)
    (when (and (>= i 0)
               *flush-on-newline*)
      (flush))))


(defn with-retries [n thunk]
  "Make n attempts to invoke a thunk, otherwise failing with exception.

  (with-retries 3 #(println \"hello\"))

  would attempt 3 invocations of the thunk or else throw an exception."
  (loop [i (dec n)]
    (if-let [res (try
                   [(thunk)]
                   (catch Exception e
                     (when (zero? i)
                       (throw e))))]
      (res 0)
      (recur (dec i)))))



