import React, { useEffect, useState } from 'react';
import { getAllPost } from '../Api/BlogApi';
import { Link } from 'react-router-dom';

const Home = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    const fetchAllPost = async () => {
      const { data } = await getAllPost();
      setPosts(data);
    };
    fetchAllPost();
  }, []);

  return (
    <div className=''>
        <img src='/blog.webp' alt='blog image' className='w-full h-[320px]'/>
    <div className="max-w-6xl mx-auto ">
      <h1 className="bg-black text-white p-4 text-3xl font-bold mb-6 font-serif">Blogger.io</h1>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {posts?.map((post) => (
          <div
            key={post?.id}
            className="border rounded-lg shadow-md p-4 hover:shadow-lg transition"
          >
            <Link to={`/${post?.id}`}>
              <img
                className="h-48 w-full object-cover rounded-md mb-4"
                src={post?.image_url}
                alt="post"
              />
            </Link>
            <h2 className="text-xl font-semibold mb-2">{post?.title}</h2>
            <p className="text-gray-600 mb-2">{post?.subheading}</p>
            <p className="text-gray-500 text-sm mb-1">
              By {post?.author} | Published on: {post?.published_date}
            </p>
          </div>
        ))}
      </div>

      <div className="mt-8">
        <Link
          to="/create"
          className="px-6 py-3 bg-black text-white rounded-lg"
        >
          Create Post
        </Link>
      </div>
    </div>
    </div>
  );
};

export default Home;
