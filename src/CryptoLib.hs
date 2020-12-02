module CryptoLib (eea, eulerPhi, modInv, fermatPT, hashCP) where

-- | Returns a triple (gcd, s, t) such that gcd is the greatest common divisor
-- of a and b, and gcd = a*s + b*t.
eea :: (Int, Int) -> (Int, Int, Int)
eea (a, b) = (-1, -1, -1)

-- | Returns Euler's Totient for the value n.
eulerPhi :: Int -> Int
eulerPhi n = -1

-- | Returns the value v such that n*v = 1 (mod m).
-- Returns 0 if the modular inverse does not exist.
modInv :: (Int, Int) -> Int
modInv (n, m) = -1

-- | Returns 0 if n is a Fermat Prime, otherwise it returns the lowest
-- Fermat Witness. Tests values from 2 (inclusive) to n/3 (exclusive).
fermatPT :: Int -> Int
fermatPT n = -1

-- | Returns the probability that calling a perfect hash function with
-- n_samples (uniformly distributed) will give one collision (i.e. that
-- two samples result in the same hash) -- where size is the number of
-- different output values the hash function can produce.
hashCP :: (Double, Double) -> Double
hashCP (n_samples, size) = -1
