type Counter = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): Counter {
    let count : number = init

    const increment = () => {
        return ++count
    }
    const decrement = () => {
        return --count
    }
    const reset = () => {
        count = init
        return init
    }

    return {
        increment, decrement, reset
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */