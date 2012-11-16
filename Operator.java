abstract class Operator extends Node
{
    public abstract int getPriority();
    public abstract ExpVal eval(ExpVal a, ExpVal b);
}
