using System;
using System.Collections.Generic;
using Server.domain;

namespace Server.repository
{
    interface IDatabaseRepository<T, in TId> : IRepository<T, TId> where T : IHasId<TId>
    {
        List<T> GetAllByProperties(Dictionary<String, String> dictionary);
    }
}
